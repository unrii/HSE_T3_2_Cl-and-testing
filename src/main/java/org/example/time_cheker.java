package org.example;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class time_cheker {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(time_cheker.class.getSimpleName())
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(1)
                .build();
        new Runner(options).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void measure_max(){
        Main._max(Main.read("benchmarks/ttest5.txt"));

    }
}

