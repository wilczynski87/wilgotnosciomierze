package com.mokrosc.MichalaP.service

import com.azure.storage.blob.BlobContainerClient
import com.azure.storage.blob.BlobServiceClient
import com.azure.storage.blob.BlobServiceClientBuilder
import com.mokrosc.MichalaP.dto.BlobContentStringDto
import com.mokrosc.MichalaP.entity.BlobContent
import kotlinx.serialization.json.Json
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.stream.Stream

@Service
class AzureBlobController {
    private val baseUrl:String = "https://iotdatastorage1.blob.core.windows.net/"
    private val containerName:String = "solimessages"

    @Value("container.token")
    var token:String = "sv=2022-11-02&ss=bfqt&srt=sco&sp=rwdlacupiytfx&se=2024-10-03T19:42:10Z&st=2024-10-01T11:42:10Z&spr=https,http&sig=g0sAwgc%2BabnNs6enacnda7wMwodEXDRgS%2FqEby0MvLw%3D"

    // Azure SDK client builders accept the credential as a parameter
    private var blobServiceClient: BlobServiceClient = BlobServiceClientBuilder()
        .endpoint(baseUrl)
        .sasToken(token)
//        .credential(DefaultAzureCredentialBuilder().build())
        .buildClient()

    // If needed, you can create a BlobContainerClient object from the BlobServiceClient
    private var containerClient: BlobContainerClient = blobServiceClient
        .getBlobContainerClient(containerName)

    fun downloadBlobsContent(): List<BlobContent> {
        return containerClient.listBlobs().stream().limit(50)
            .map { it.name }
//            .peek{ println("name: " + it) }
            .flatMap { getJsonBlobContent(it) }
//            .peek{ println("Json content: " + it) }
            .map { getBlobContent(it) }
//            .peek{ println("BolbContent: " + it) }
            .toList()
    }
    private val getJsonBlobContent: (name:String) -> Stream<String> = {

        val blob = containerClient.getBlobClient(it)

        val blobContent = blob.downloadContent().toString()

        val spliter = blobContent.split("\n")

//        println(blobContent)

        spliter.stream()
    }

    private val getBlobContent: (blob:String) -> BlobContent = {
        val deserializedUser:BlobContentStringDto = Json.decodeFromString(it)
//        println("deserializedBlob: ${deserializedUser.blobContentStringDtoToBlobContent()} \n")
        deserializedUser.blobContentStringDtoToBlobContent()
    }

}