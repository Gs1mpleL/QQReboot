package com.wanfeng.qqreboot.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LaoPo {
    private int maxWeight = 200;
    private int minWeight = 80;
    private int maxHeight = 180;
    private int minHeight = 150;
    private int weight;
    private int height;
    Random random = new Random();
    private List<String> grande =  Arrays.asList("男","女","伪娘");
    public LaoPo() {

        this.weight = random.nextInt(maxWeight-minWeight) + minWeight;
        this.height = random.nextInt(maxHeight-minHeight) + maxHeight;

    }

    public String toString(String nickName) {
        return nickName + ":\n" + "身高:[" + height+"]\n" + "体重:[" + weight+"]\n性别:[" + grande.get(random.nextInt(grande.size())) + "]";
    }
}
