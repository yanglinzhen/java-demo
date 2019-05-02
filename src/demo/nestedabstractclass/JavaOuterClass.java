package demo.nestedabstractclass;

public class JavaOuterClass {
    public abstract class JavaInnerClass {
        abstract void abstractMethod();
        public final void method() {
            System.out.println("this is method");
        }
    }

    private JavaInnerClass innerClassInstance;

    public void setInnerClassInstance(JavaInnerClass innerClassInstance) {
        this.innerClassInstance = innerClassInstance;
    }

    public void runInnerAbstractMethod () {
        if (innerClassInstance == null) return;
        innerClassInstance.abstractMethod();
    }

    public interface AbstractAction {
        void doAction(JavaInnerClass instance);
    }

    public JavaInnerClass getInnerClass(AbstractAction action) {
        return new JavaInnerClass() {
            @Override
            void abstractMethod() {
                action.doAction(this);
            }
        };
    }
}
