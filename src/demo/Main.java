package demo;

import demo.classloader.CCRun;

public class Main {

    public static void main(String[] args) {
        new demo.annotation.AnnotationDemo().runDemo(args);
        new CCRun().runDemo(args);
    }
}
