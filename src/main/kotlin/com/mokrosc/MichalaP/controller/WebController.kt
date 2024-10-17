package com.mokrosc.MichalaP.controller

import com.mokrosc.MichalaP.entity.BlobContent
import com.mokrosc.MichalaP.service.AzureBlobController
import com.mokrosc.MichalaP.service.ChartService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/")
class WebController(
    val chartService: ChartService,
    val azureBlobController: AzureBlobController,
) {


    @GetMapping
    fun index(model:Model): String {
        println("\nindex page refreshed\n")
//        val moistureMeasurements = listOf(
//            arrayOf(0, 0, 0), arrayOf(1, 10, 5), arrayOf(2, 23, 15), arrayOf(3, 17, 9), arrayOf(4, 18, 10), arrayOf(5, 9, 5),
//        )
        val blobContent:List<BlobContent> = azureBlobController.downloadBlobsContent()
        val moistureMeasurements = chartService.blobContentListToArray(blobContent);
        model.addAttribute("moistureMeasurements", moistureMeasurements)
        return "index"
    }

}