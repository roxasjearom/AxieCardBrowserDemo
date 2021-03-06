package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.mapper

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.local.entity.OriginCardEntity
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.remote.response.OriginCardDto
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.model.OriginCard

fun OriginCardDto.toEntity() = OriginCardEntity(
    id = id,
    cardDamage = cardDamage,
    cardEnergy = cardEnergy,
    cardHeal = cardHeal,
    cardImage = cardImage,
    cardName = cardName,
    cardShield = cardShield,
    cardText = cardText,
    cardType = cardType,
    cardClass = cardClass,
    partId = partId,
    partName = partName,
    partType = partType,
    tags = tags,
)

fun OriginCardEntity.toOriginCard() = OriginCard(
    cardDamage = cardDamage,
    cardEnergy = cardEnergy,
    cardHeal = cardHeal,
    cardImage = cardImage,
    cardName = cardName,
    cardShield = cardShield,
    cardText = cardText,
    cardType = cardType,
    cardClass = cardClass,
    tags = tags,
    partType = partType,
)
