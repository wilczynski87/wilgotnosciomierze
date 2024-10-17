package com.mokrosc.MichalaP.service

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class FechFromBolb {
    private var restTemplate = RestTemplate()

    fun fetchDataIoT() {
        restTemplate
    }
}