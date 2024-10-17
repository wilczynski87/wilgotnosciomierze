package com.mokrosc.MichalaP.service

import com.mokrosc.MichalaP.entity.BlobContent
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ChartService {

    fun blobContentListToArray(blobList:List<BlobContent>): Array<out Any> {
        return blobList.stream()
            .map{
                arrayOf(
                    it.enqueuedTimeUtc,
                    it.body.soilMoisture1,
                    it.body.soilMoisture2,
                    it.body.soilMoisture3,
                    it.body.soilMoisture4,)
            }
            .toArray()
    }
}