package junit5.example;

public class J20ParallelExecution {
    /*By default, JUnit Jupiter tests are run sequentially in a single thread.
    Running tests in parallel — for example, to speed up execution — is
     available as an opt-in feature since version 5.3. To enable parallel execution,
      set the junit.jupiter.execution.parallel.enabled configuration parameter
       to true — for example, in junit-platform.properties

       Please note that enabling this property is only the first step required to execute tests in parallel. If enabled, test classes and methods will still be executed sequentially by default. Whether or not a node in the test tree is executed concurrently is controlled by its execution mode. The following two modes are available.

SAME_THREAD
Force execution in the same thread used by the parent. For example, when used on a test method, the test method will be executed in the same thread as any @BeforeAll or @AfterAll methods of the containing test class.

CONCURRENT
Execute concurrently unless a resource lock forces execution in the same thread.




Configuration
Properties such as the desired parallelism and the maximum pool size can be configured using a ParallelExecutionConfigurationStrategy. The JUnit Platform provides two implementations out of the box: dynamic and fixed. Alternatively, you may implement a custom strategy.

To select a strategy, set the junit.jupiter.execution.parallel.config.strategy configuration parameter to one of the following options.

dynamic
Computes the desired parallelism based on the number of available processors/cores multiplied by the junit.jupiter.execution.parallel.config.dynamic.factor configuration parameter (defaults to 1). The optional junit.jupiter.execution.parallel.config.dynamic.max-pool-size-factor configuration parameter can be used to limit the maximum number of threads.

fixed
Uses the mandatory junit.jupiter.execution.parallel.config.fixed.parallelism configuration parameter as the desired parallelism. The optional junit.jupiter.execution.parallel.config.fixed.max-pool-size configuration parameter can be used to limit the maximum number of threads.

     */

}
