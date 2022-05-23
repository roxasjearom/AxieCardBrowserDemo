package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.remote.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OriginData(
    val cards: List<OriginCardDto>
)
