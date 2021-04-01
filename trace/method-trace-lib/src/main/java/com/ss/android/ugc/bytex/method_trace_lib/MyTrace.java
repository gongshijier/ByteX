package com.ss.android.ugc.bytex.method_trace_lib;

import android.os.Trace;

public class MyTrace {
    public static void beginSection(String tag) {
        Trace.beginSection(tag);
    }

    public static void endSection() {
        Trace.endSection();
    }

}
