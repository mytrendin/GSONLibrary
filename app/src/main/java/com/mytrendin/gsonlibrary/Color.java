
package com.mytrendin.gsonlibrary;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Color {

    @SerializedName("colorsArray")
    @Expose
    private List<ColorsArray> colorsArray = null;

    public List<ColorsArray> getColorsArray() {
        return colorsArray;
    }

    public void setColorsArray(List<ColorsArray> colorsArray) {
        this.colorsArray = colorsArray;
    }

}
