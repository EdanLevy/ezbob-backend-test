package com.edan.api.Model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize
public record ShuffleRequestPayload(int number) {
}
