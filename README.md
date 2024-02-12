# HelloJNI

本项目是一个简单的示例代码，演示了如何使用 JNI 调用 C++ 编译出来的代码：

C++ 代码（hello.cpp）：

```cpp
#include <iostream>
#include "Hello.h"
using namespace std;

JNIEXPORT void JNICALL Java_com_example_Hello_printHello(JNIEnv *env, jobject obj) {
cout << "Hello from C++!" << endl;
}
```

其中，"Hello.h" 是通过 javah 工具生成的 JNI 头文件。

Java 代码（Hello.java）：
```java
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
```

使用以下命令生成 JNI 头文件：

```
javac Hello.java
javah -jni Hello
```

然后编译 C++ 代码并生成共享库文件：

MacOS 系统：
```
g++ -c -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin" hello.cpp
g++ -dynamiclib -o libhello.dylib hello.o
```

Linux 系统：
```
g++ -c -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" hello.cpp
g++ -shared -o libhello.so hello.o
```

最后，执行 Java 代码：

```
java Hello
```

以上使用 JNI 调用 C++ 编译出来的代码，输出结果将会是 "Hello from C++!"。
