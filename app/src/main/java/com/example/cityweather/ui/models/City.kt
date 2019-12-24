package com.example.cityweather.ui.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(strict = false)
data class City(
    @Element(name = "areaName")
    var areaName: String,
    @Element(name = "country")
    var country: String,
    @Element(name = "region")
    var region: String,
    @Element(name = "latitude")
    var latitude: String,
    @Element(name = "longitude")
    var longitude: String,
    @Element(name = "population")
    var population: String,
    @Element(name = "weatherUrl")
    var weatherUrl: String
) {

}