package com.mokrosc.MichalaP.controller

import com.azure.storage.blob.BlobContainerClient
import com.mokrosc.MichalaP.entity.BlobContent
import com.mokrosc.MichalaP.service.AzureBlobController
import com.mokrosc.MichalaP.service.BlobHandling
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    val azureBlobController: AzureBlobController
    , val blobHandler:BlobHandling
) {

    @GetMapping("/healthCheck")
    fun healthCheck(): ResponseEntity<String> {
        return ResponseEntity("I am healthy!", HttpStatus.OK);
    }

    @GetMapping("restTemplateTest")
    fun getObjects() {
        println("\nrestTemplateTest\n")
//        restTemplate.getListOfMeasurements()
    }

    @GetMapping("restTemplateTest2")
    fun getObjects2() {
        println("\nrestTemplateTest2\n")
        val blobContent:List<BlobContent> = azureBlobController.downloadBlobsContent()
    }

}