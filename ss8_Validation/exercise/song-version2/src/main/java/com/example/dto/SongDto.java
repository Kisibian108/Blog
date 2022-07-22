package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {

    private int id; //0

    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String name;

    @NotBlank
    @Size(max = 300)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String artist;

    @NotBlank
    @Size(max = 1000)
    @Pattern(regexp = "^(?![0-9.,])(?!.*[0-9.,]$)(?!.*\\d,)(?!.*,\\d)[a-zA-Z0-9,]+$")
    private String style;
    private String url;

    public SongDto() {
    }

    public SongDto(int id, String name, String artist, String style, String url) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.style = style;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", style='" + style + '\'' +
                ", Url='" + url + '\'' +
                '}';
    }
}
