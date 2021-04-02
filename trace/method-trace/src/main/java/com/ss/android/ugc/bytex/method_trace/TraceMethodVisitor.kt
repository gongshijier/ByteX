package com.ss.android.ugc.bytex.method_trace

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.commons.AdviceAdapter

class TraceMethodVisitor(private var context: MethodTraceContext,
                         private var className: String, api: Int, mv: MethodVisitor?,
                         access: Int, var methodName: String?, desc: String?
) : AdviceAdapter(api, mv, access, methodName, desc) {


    override fun onMethodEnter() {
        super.onMethodEnter()

        context.logger.i("TraceMethodVisitor", "----插桩----className: $className  methodName: ${methodName}------")

        if (methodName != null) {
            mv.visitLdcInsn("$className#$methodName");
            mv.visitMethodInsn(INVOKESTATIC, "com/ss/android/ugc/bytex/method_trace_lib/MyTrace", "beginSection", "(Ljava/lang/String;)V", false);
        }
    }

    override fun onMethodExit(opcode: Int) {
        super.onMethodExit(opcode)
        mv.visitMethodInsn(INVOKESTATIC, "com/ss/android/ugc/bytex/method_trace_lib/MyTrace", "endSection", "()V", false);

    }
}