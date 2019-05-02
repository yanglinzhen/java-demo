package demo.nestedabstractclass

import demo.BaseDemo

class KotlinCaller: BaseDemo {
    override fun runDemo(args: Array<out String>?) {
        val innerClass = JavaOuterClass().getInnerClass {
            it.method()
        }
        JavaOuterClass().apply {
            setInnerClassInstance(innerClass)
            runInnerAbstractMethod()
        }
    }
}