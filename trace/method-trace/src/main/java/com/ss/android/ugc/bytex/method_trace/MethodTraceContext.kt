package com.ss.android.ugc.bytex.method_trace

import com.android.build.gradle.AppExtension
import com.ss.android.ugc.bytex.common.BaseContext
import com.ss.android.ugc.bytex.common.white_list.WhiteList
import org.gradle.api.Project

class MethodTraceContext(project: Project,
                         android: AppExtension, extension: MethodTraceExtension
) : BaseContext<MethodTraceExtension>(project, android, extension) {
    fun shouldTrace(className: String?, name: String?): Boolean {

        var isNotConstruct = true

        if (name != null) {
            if (name.contains("<clinit>") || name.contains("<init>")) {
                isNotConstruct = false
            }
        }
        return isNotConstruct && inWhiteList(className)
    }

    private fun inWhiteList(className: String?): Boolean {
        if (className == null) return false
        whiteList.forEach {
            if (className.contains(it)) {
                return true
            }
        }
        return false
    }

    var whiteList = ArrayList<String>()

    override fun init() {
        super.init()
        whiteList = extension.whiteList as ArrayList<String>
    }
}
