package com.example.singh.punjabi;

/**
 * Created by SINGH on 24/10/17.
 */

public class Words {
    private String English_word;
    private String Punjabi_word;
    private int images;
    private int Audio;

    public Words(String English_word,String Punjabi_word,int images,int Audio)
    {
        this.English_word=English_word;
        this.Punjabi_word=Punjabi_word;
        this.images=images;
        this.Audio=Audio;
    }

    public String getEnglish_word()
    {
        return English_word;
    }

    public String getPunjabi_word()
    {
        return Punjabi_word;
    }

    public int getImages() {
        return images;
    }
    public  int getAudio()
    {
        return Audio;
    }
}
