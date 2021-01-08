package org.asamk.signal.manager;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

class JsonStickerPack {

    @JsonProperty
    public String title;

    @JsonProperty
    public String author;

    @JsonProperty
    public JsonSticker cover;

    @JsonProperty
    public List<JsonSticker> stickers;

    public static class JsonSticker {

        @JsonProperty
        public String emoji;

        @JsonProperty
        public String file;
    }
}
