package com.ss.android.ugc.bytex.method_trace

import com.ss.android.ugc.bytex.common.visitor.BaseClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class MethodTraceClassVisitor(private var context: MethodTraceContext, extension: MethodTraceExtension?) : BaseClassVisitor() {

    lateinit var mClassName: String

    override fun visitSource(source: String?, debug: String?) {
        super.visitSource(source, debug)
    }

    override fun visit(version: Int, access: Int, name: String?, signature: String?, superName: String?, interfaces: Array<out String>?) {
        super.visit(version, access, name, signature, superName, interfaces)
        if (name != null) {
            mClassName = name
        }
    }

    override fun visitMethod(
            access: Int,
            name: String?,
            descriptor: String?,
            signature: String?,
            exceptions: Array<out String>?
    ): MethodVisitor {

        val methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
        if (mClassName.contains("com/ss/android/ugc/bytex/example")) {
            return TraceMethodVisitor(context, mClassName, Opcodes.ASM6, methodVisitor, access, name, descriptor)
        }
        return methodVisitor
    }
}
