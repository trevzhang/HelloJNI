public class Hello {
    static {
        System.loadLibrary("hello"); // 加载编译好的共享库文件
    }

    private native void printHello(); // 声明本地方法

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.printHello(); // 调用本地方法
    }
}

