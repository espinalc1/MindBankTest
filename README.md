# MindBankTest

Does the solution work for larger graphs?


This solution will not work for weights that, after calculating the largest path, exceed Integer.MAX_VALUE. The method that uses Topological Sorting (Kahns Algorithm) (DagUtil.longestPathInDagFromUsingTopSort) is linear, but doesn’t start from a specified vertex. This method can find the Longest Path in linear fashion regardless of the size of the DAG.

The method that doesn’t use Topological sorting (longestPathInDagFromSpecifiedVertex), uses a depth first search approach but, at the very least, can handle DAGs with multiple sources. However, since it traverses a Dag via a queue, it’s possible that nodes will be traversed multiple times. This is the least efficient approach.


Can you think of any optimizations?


(DagUtil.longestPathInDagFromUsingTopSort) should generalize to Dags with multiple source nodes. I can do this by choosing the source vertex first, generating an indegree memo starting from the source vertex, generating a topological sorting, and then invoke the longest path algorithm.
 
(DagUtil.longestPathInDagFromSpecifiedVertex) should use topological sorting to make it linear, just the first method described.


What’s the computational complexity of your solution?


Given that it utilizes Dynamic Programming with Kahn’s algorithm to Topological Sorting, it is O(T+D), or linear.


Are there any unusual cases that aren’t handled?


This doesn’t handle weighted edges. However, with a simple modification, it can handle weighted edges and even negative numbers given the algorithm used to solve the DAG problem. Lastly, the first algorithm, (DagUtil.longestPathInDagFromUsingTopSort), doesn’t start from a specified vertex, the source. It generates the solution based on the entire DAG, even with multiple source vertices. This wouldn’t be correct with a constraint where the problem requires the longest path from a specific source vertex.


What are some things you don’t like about Java?


I think that Java has developed into a programming language that tries to do too many things, including functional programming. Because of this, it forces users to create functions in an object oriented way. Although I can understand that it leads to more efficiencies, I'd prefer to use languages designed for this purpose than java - such as a Scala.


If you could choose any language/framework/technology stack, what would you choose and
why?


I would like Angular or ReactJS with Typescript on the front end, with Springboot and java on the backend. On the front end, Angular and ReactJS have tools to quickly develop stateful and reusable web interface components and Typescript would simplify the process for passing around stateful objects on the frontend and remove some of the difficulties and confusion that come with dynamically typed languages. On the backend, I'd prefer Springboot and Java because Java is itself a clear implementation of the OOP standards, and Springboot abstracts away all of the common boilerplate code that one would have to otherwise write just to make a basic API. 