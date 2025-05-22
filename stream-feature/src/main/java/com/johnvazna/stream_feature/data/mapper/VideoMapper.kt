package com.johnvazna.stream_feature.data.mapper

import com.johnvazna.stream_feature.data.models.VideoDto
import com.johnvazna.stream_feature.domain.models.Video

object VideoMapper {
    fun fromDto(dto: VideoDto) = Video(dto.name, dto.author, dto.url)
    fun fromList(dtos: List<VideoDto>) = dtos.map(::fromDto)
}
