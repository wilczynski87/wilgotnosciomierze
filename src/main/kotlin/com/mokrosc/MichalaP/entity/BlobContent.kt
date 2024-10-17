package com.mokrosc.MichalaP.entity

import com.mokrosc.MichalaP.dto.SystemProperties
import java.time.OffsetDateTime

class BlobContent(
    val enqueuedTimeUtc: OffsetDateTime?,
    var properties:Map<String, String>?,
    var systemProperties: SystemProperties?,
    val body:SoilMeasurements,
) {
    override fun toString(): String {
        return "BlobContent(enqueuedTimeUtc=$enqueuedTimeUtc, properties=$properties, systemProperties=$systemProperties, body=$body)"
    }
}