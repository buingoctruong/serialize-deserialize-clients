# Benchmark of Java XML libraries

<!-- TOC -->
* [Benchmark of Java XML libraries](#benchmark-of-java-xml-libraries)
  * [Purpose](#purpose)
  * [Results](#results)
    * [Clients data](#clients-data)
      * [Deserialization](#deserialization)
        * [1 KB](#1-kb)
        * [10 KB](#10-kb)
        * [100 KB](#100-kb)
      * [Serialization](#serialization)
        * [1 KB](#1-kb-1)
        * [10 KB](#10-kb-1)
        * [100 KB](#100-kb-1)
    * [Users data](#users-data)
      * [Deserialization](#deserialization-1)
        * [1 KB](#1-kb-2)
        * [10 KB](#10-kb-2)
        * [100 KB](#100-kb-2)
      * [Serialization](#serialization-1)
        * [1 KB](#1-kb-3)
        * [10 KB](#10-kb-3)
        * [100 KB](#100-kb-3)
    * [Benchmark configuration](#benchmark-configuration)
  * [Run](#run)
<!-- TOC -->

## Purpose

This project benchmarks the throughput performance of a variety of Java XML libraries
using [JMH](https://openjdk.org/projects/code-tools/jmh/).
It covers the following libraries:

* [xstream](https://github.com/x-stream/xstream)
* [jackson](https://github.com/FasterXML/jackson-dataformat-xml)
* [jaxb-api](https://github.com/jakartaee/jaxb-api)

When available, databinding implementations are tested.
Two different kinds of [models](src/main/java/github/io/truongbn/xmlclients/model) are evaludated with payloaded of 1,
10, 100 and 1000 KB size:

* [`Users`](src/main/java/github/io/truongbn/xmlclients/model/Users.java): uses primitive types, String, List and
  simple POJOs.
* [`Clients`](src/main/java/github/io/truongbn/xmlclients/model/Clients.java): adds arrays, enum, UUID, LocalDate.

This benchmark is written to:

* Randomly generate payloads upon static loading of the JVM/benchmark, the *seed* is also shared across runs.
* Read data from RAM.
* Write data to reusable output streams (when possible), this reduces allocation pressure.
* Consume all output streams to avoid dead code elemination optimization.

Not evaluated are: RAM utilization, compression, payloads > 1 MB.

## Results

The benchmarks are written with [JMH](https://openjdk.org/projects/code-tools/jmh/) and for Java 17.

### Clients data

#### Deserialization

##### 1 KB

| Benchmark   | Mode  | Cnt | Score      | Error     | Units |
|-------------|-------|-----|------------|-----------|-------|
| jackson_xml | thrpt | 20  | 150755.523 | ±5869.229 | ops/s |
| context     | thrpt | 20  | 32620.090  | ±3448.008 | ops/s |
| stream_xml  | thrpt | 20  | 30548.271  | ±1579.083 | ops/s |

##### 10 KB

| Benchmark   | Mode  | Cnt | Score     | Error    | Units |
|-------------|-------|-----|-----------|----------|-------|
| jackson_xml | thrpt | 20  | 11240.768 | ±546.258 | ops/s |
| context     | thrpt | 20  | 10582.705 | ±797.889 | ops/s |
| stream_xml  | thrpt | 20  | 5088.913  | ±373.473 | ops/s |

##### 100 KB

| Benchmark   | Mode  | Cnt | Score    | Error   | Units |
|-------------|-------|-----|----------|---------|-------|
| jackson_xml | thrpt | 20  | 1338.998 | ±86.117 | ops/s |
| context     | thrpt | 20  | 1117.174 | ±30.854 | ops/s |
| stream_xml  | thrpt | 20  | 570.484  | ±17.517 | ops/s |

#### Serialization

##### 1 KB

| Benchmark   | Mode  | Cnt | Score      | Error      | Units |
|-------------|-------|-----|------------|------------|-------|
| jackson_xml | thrpt | 20  | 454764.664 | ±15019.015 | ops/s |
| context     | thrpt | 20  | 236166.559 | ±9899.349  | ops/s |
| stream_xml  | thrpt | 20  | 50481.457  | ±1239.063  | ops/s |

##### 10 KB

| Benchmark   | Mode  | Cnt | Score     | Error     | Units |
|-------------|-------|-----|-----------|-----------|-------|
| jackson_xml | thrpt | 20  | 38546.913 | ±1034.746 | ops/s |
| context     | thrpt | 20  | 29296.501 | ±1470.335 | ops/s |
| stream_xml  | thrpt | 20  | 4308.410  | ±288.483  | ops/s |

##### 100 KB

| Benchmark   | Mode  | Cnt | Score    | Error   | Units |
|-------------|-------|-----|----------|---------|-------|
| jackson_xml | thrpt | 20  | 3665.245 | ±53.310 | ops/s |
| context     | thrpt | 20  | 3147.432 | ±93.448 | ops/s |
| stream_xml  | thrpt | 20  | 444.159  | ±28.043 | ops/s |

### Users data

#### Deserialization

##### 1 KB

| Benchmark   | Mode  | Cnt | Score      | Error     | Units |
|-------------|-------|-----|------------|-----------|-------|
| jackson_xml | thrpt | 20  | 158172.702 | ±5197.667 | ops/s |
| context     | thrpt | 20  | 33432.102  | ±836.269  | ops/s |
| stream_xml  | thrpt | 20  | 30037.388  | ±1586.353 | ops/s |

##### 10 KB

| Benchmark   | Mode  | Cnt | Score     | Error    | Units |
|-------------|-------|-----|-----------|----------|-------|
| jackson_xml | thrpt | 20  | 18995.526 | ±697.246 | ops/s |
| context     | thrpt | 20  | 10413.995 | ±327.507 | ops/s |
| stream_xml  | thrpt | 20  | 5644.530  | ±42.585  | ops/s |

##### 100 KB

| Benchmark   | Mode  | Cnt | Score    | Error    | Units |
|-------------|-------|-----|----------|----------|-------|
| jackson_xml | thrpt | 20  | 1867.943 | ±57.614  | ops/s |
| context     | thrpt | 20  | 938.462  | ±155.633 | ops/s |
| stream_xml  | thrpt | 20  | 596.551  | ±13.751  | ops/s |

#### Serialization

##### 1 KB

| Benchmark   | Mode  | Cnt | Score      | Error      | Units |
|-------------|-------|-----|------------|------------|-------|
| jackson_xml | thrpt | 20  | 336918.849 | ±14809.694 | ops/s |
| context     | thrpt | 20  | 217473.812 | ±9144.775  | ops/s |
| stream_xml  | thrpt | 20  | 24010.315  | ±388.419   | ops/s |

##### 10 KB

| Benchmark   | Mode  | Cnt | Score     | Error     | Units |
|-------------|-------|-----|-----------|-----------|-------|
| jackson_xml | thrpt | 20  | 53350.661 | ±3802.159 | ops/s |
| context     | thrpt | 20  | 27070.737 | ±2256.284 | ops/s |
| stream_xml  | thrpt | 20  | 3217.198  | ±168.067  | ops/s |

##### 100 KB

| Benchmark   | Mode  | Cnt | Score    | Error    | Units |
|-------------|-------|-----|----------|----------|-------|
| jackson_xml | thrpt | 20  | 4591.387 | ±156.211 | ops/s |
| context     | thrpt | 20  | 2912.102 | ±230.063 | ops/s |
| stream_xml  | thrpt | 20  | 335.970  | ±17.589  | ops/s |

### Benchmark configuration

JMH info:

```
# JMH version: 1.36
# VM version: JDK 17.0.4.1, OpenJDK 64-Bit Server VM, 17.0.4.1+1
# VM invoker: /Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home/bin/java
# VM options: --add-opens=java.base/java.time=ALL-UNNAMED -Xms2g -Xmx2g
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 10 iterations, 3 s each
# Timeout: 10 min per iteration
# Threads: 16 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
```

## Run

By default, running `./run ser` (`./run deser` respectively) will run all databind -- serialization (deserialization
respectively) benchmarks with 1 KB payloads of _Users_.

You can also specify with libs, apis, payload-sizes and number of iterations (and more) you want to run. for example:

    ./run deser --apis databind --libs jackson_xml
    ./run ser --apis databind --libs stream_xml
    ./run deser --apis stream --libs jackson_xml,stream_xml --size 10 --datatype users

Type `./run help ser` or `./run help deser` to print help for those commands.