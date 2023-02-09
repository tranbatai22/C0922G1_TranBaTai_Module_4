package com.example.song_info.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto{
    private int id;

    @NotBlank(message = "không được để trống")
    @Size(min = 1, max = 800, message = "Không quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*", message = "Không được chứa ký tự đặc biệt")
    private String name;

    @NotBlank(message = "không được để trống")
    @Size(min = 1, max = 300, message = "Không quá 300 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*", message = "Không được chứa ký tự đặc biệt")
    private String artist;

    @NotBlank(message = "không được để trống")
    @Size(min = 1, max = 1000, message = "Không quá 1000 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9,]+", message = "Không được chứa ký tự đặc biệt trừ dấu phẩy")
    private String category;

    public SongDto() {
    }

    public SongDto(int id, String name, String artist, String category) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
