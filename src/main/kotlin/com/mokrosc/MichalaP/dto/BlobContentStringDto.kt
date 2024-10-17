package com.mokrosc.MichalaP.dto

import com.mokrosc.MichalaP.entity.BlobContent
import com.mokrosc.MichalaP.entity.SoilMeasurements
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.*

@Serializable
data class BlobContentStringDto (
    val EnqueuedTimeUtc:String?,
    var Properties:Map<String, String>?,
    var SystemProperties: SystemProperties?,
    val Body:String?,
) {
    private fun atob(encoded:String): SoilMeasurements {
        val decoded = String(Base64.getDecoder().decode(encoded))
//        println("decoded: \n$decoded")
        val soilMeasurements: SoilMeasurements = Json.decodeFromString(decoded)
        return soilMeasurements
    }

    fun blobContentStringDtoToBlobContent(): BlobContent {
        return BlobContent(
                this.EnqueuedTimeUtc?.let { OffsetDateTime.parse(it) },
                this.Properties,
                this.SystemProperties,
                this.Body?.let { atob(it) } ?: SoilMeasurements(null, null, null, null, null)
            )
    }
}

@Serializable
data class SystemProperties(
    val connectionDeviceId: String,
    val connectionAuthMethod: String,
    val connectionDeviceGenerationId: String,
    val enqueuedTime: String
)