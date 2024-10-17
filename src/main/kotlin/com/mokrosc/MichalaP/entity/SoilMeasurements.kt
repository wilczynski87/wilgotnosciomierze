package com.mokrosc.MichalaP.entity

import kotlinx.serialization.Serializable

@Serializable
data class SoilMeasurements(
    val msgCount: Int?,
    val soilMoisture1: Long?,
    val soilMoisture2: Long?,
    val soilMoisture3: Long?,
    val soilMoisture4: Long?,
    val soilMoisture5: Long? = null,
) { }