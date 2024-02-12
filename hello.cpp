#include <iostream>
#include "Hello.h"
using namespace std;

JNIEXPORT void JNICALL Java_Hello_printHello(JNIEnv *env, jobject obj) {
    cout << "Hello from C++!" << endl;
}

