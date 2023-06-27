package com.dp.todo.dto

import com.fasterxml.jackson.annotation.JsonProperty

class TodoCreationRequest {

    @JsonProperty("title")
    var title: String? = null

    @JsonProperty("completed")
    var completed: Boolean? = false
}