package mindBankTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestConnectedDagDataSetOne();
	}

	public static void TestConnectedDagDataSetOne() {
		System.out.println("Data Set 1 - Connected DAG Data Set:");
		Long[] vertexIds = { 1000000000001L, 1000000000002L, 1000000000003L, 1000000000004L, 1000000000005L,
				1000000000006L, 1000000000007L, 1000000000008L, 1000000000009L, 1000000000010L, 1000000000011L,
				1000000000012L, 1000000000013L, 1000000000014L, 1000000000015L, 1000000000016L, 1000000000017L,
				1000000000018L, 1000000000019L, 1000000000020L };

		List<Long> verticesIdList = Arrays.asList(vertexIds);
		Set<Vertex> vertices = Vertex.generateVertices(verticesIdList);
		List<List<Long>> edges = new ArrayList<>();
		// queue: 2, 3
		// top: 1
		edges.add(Arrays.asList(1000000000001L, 1000000000002L));
		edges.add(Arrays.asList(1000000000001L, 1000000000003L));
		edges.add(Arrays.asList(1000000000002L, 1000000000004L));
		edges.add(Arrays.asList(1000000000002L, 1000000000005L));
		edges.add(Arrays.asList(1000000000003L, 1000000000006L));
		edges.add(Arrays.asList(1000000000004L, 1000000000007L));
		edges.add(Arrays.asList(1000000000005L, 1000000000007L));
		edges.add(Arrays.asList(1000000000006L, 1000000000008L));
		edges.add(Arrays.asList(1000000000007L, 1000000000009L));
		edges.add(Arrays.asList(1000000000008L, 1000000000009L));
		edges.add(Arrays.asList(1000000000009L, 1000000000010L));
		edges.add(Arrays.asList(1000000000010L, 1000000000011L));
		edges.add(Arrays.asList(1000000000011L, 1000000000012L));
		edges.add(Arrays.asList(1000000000012L, 1000000000013L));
		edges.add(Arrays.asList(1000000000013L, 1000000000014L));
		edges.add(Arrays.asList(1000000000014L, 1000000000015L));
		edges.add(Arrays.asList(1000000000015L, 1000000000016L));
		edges.add(Arrays.asList(1000000000016L, 1000000000017L));
		edges.add(Arrays.asList(1000000000017L, 1000000000018L));
		edges.add(Arrays.asList(1000000000018L, 1000000000019L));
		edges.add(Arrays.asList(1000000000019L, 1000000000020L));

		List<Edge> edgeList = DagUtil.generateEdgeList(edges);
		Map<Vertex, Integer> expectedIndegreesMap = new HashMap<>();

		expectedIndegreesMap.put(new Vertex(1000000000001L), 0);
		expectedIndegreesMap.put(new Vertex(1000000000002L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000003L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000004L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000005L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000006L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000007L), 2);
		expectedIndegreesMap.put(new Vertex(1000000000008L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000009L), 2);
		expectedIndegreesMap.put(new Vertex(1000000000010L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000011L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000012L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000013L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000014L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000015L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000016L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000017L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000018L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000019L), 1);
		expectedIndegreesMap.put(new Vertex(1000000000020L), 1);

		Map<Vertex, Integer> realIndegreesMap = DagUtil.calculateInDegrees(vertices, edgeList);
		TestIndegreesMethod(expectedIndegreesMap, realIndegreesMap);

		Map<Vertex, List<Edge>> expectedDag = new HashMap<>();
		expectedDag.put(new Vertex(1000000000001L),
				Arrays.asList(new Edge(new Vertex(1000000000001L), new Vertex(1000000000002L)),
						new Edge(new Vertex(1000000000001L), new Vertex(1000000000003L))));
		expectedDag.put(new Vertex(1000000000002L),
				Arrays.asList(new Edge(new Vertex(1000000000002L), new Vertex(1000000000004L)),
						new Edge(new Vertex(1000000000002L), new Vertex(1000000000005L))));
		expectedDag.put(new Vertex(1000000000003L),
				Arrays.asList(new Edge(new Vertex(1000000000003L), new Vertex(1000000000006L))));
		expectedDag.put(new Vertex(1000000000004L),
				Arrays.asList(new Edge(new Vertex(1000000000004L), new Vertex(1000000000007L))));
		expectedDag.put(new Vertex(1000000000005L),
				Arrays.asList(new Edge(new Vertex(1000000000005L), new Vertex(1000000000007L))));
		expectedDag.put(new Vertex(1000000000006L),
				Arrays.asList(new Edge(new Vertex(1000000000006L), new Vertex(1000000000008L))));
		expectedDag.put(new Vertex(1000000000007L),
				Arrays.asList(new Edge(new Vertex(1000000000007L), new Vertex(1000000000009L))));
		expectedDag.put(new Vertex(1000000000008L),
				Arrays.asList(new Edge(new Vertex(1000000000008L), new Vertex(1000000000009L))));
		expectedDag.put(new Vertex(1000000000009L),
				Arrays.asList(new Edge(new Vertex(1000000000009L), new Vertex(1000000000010L))));
		expectedDag.put(new Vertex(1000000000010L),
				Arrays.asList(new Edge(new Vertex(1000000000010L), new Vertex(1000000000011L))));
		expectedDag.put(new Vertex(1000000000010L),
				Arrays.asList(new Edge(new Vertex(1000000000010L), new Vertex(1000000000011L))));
		expectedDag.put(new Vertex(1000000000011L),
				Arrays.asList(new Edge(new Vertex(1000000000011L), new Vertex(1000000000012L))));
		expectedDag.put(new Vertex(1000000000012L),
				Arrays.asList(new Edge(new Vertex(1000000000012L), new Vertex(1000000000013L))));
		expectedDag.put(new Vertex(1000000000013L),
				Arrays.asList(new Edge(new Vertex(1000000000013L), new Vertex(1000000000014L))));
		expectedDag.put(new Vertex(1000000000014L),
				Arrays.asList(new Edge(new Vertex(1000000000014L), new Vertex(1000000000015L))));
		expectedDag.put(new Vertex(1000000000015L),
				Arrays.asList(new Edge(new Vertex(1000000000015L), new Vertex(1000000000016L))));
		expectedDag.put(new Vertex(1000000000016L),
				Arrays.asList(new Edge(new Vertex(1000000000016L), new Vertex(1000000000017L))));
		expectedDag.put(new Vertex(1000000000017L),
				Arrays.asList(new Edge(new Vertex(1000000000017L), new Vertex(1000000000018L))));
		expectedDag.put(new Vertex(1000000000018L),
				Arrays.asList(new Edge(new Vertex(1000000000018L), new Vertex(1000000000019L))));
		expectedDag.put(new Vertex(1000000000019L),
				Arrays.asList(new Edge(new Vertex(1000000000019L), new Vertex(1000000000020L))));

		Map<Vertex, List<Edge>> realDag = DagUtil.generateDag(edgeList);

		TestGenerateDagMethod(expectedDag, realDag);

		List<Vertex> expectedTopSortedDag = new ArrayList<>();
		for (Long i = 0L; i < 20L; i++) {
			expectedTopSortedDag.add(new Vertex(1000000000001L + i));
		}

		List<Vertex> realTopSortedDag = DagUtil.getTopSortDag(vertices, realIndegreesMap, realDag);

		TestDagTopSort(expectedTopSortedDag, realTopSortedDag);

		Map<Vertex, Integer> expectedResult = new HashMap<>();
		expectedResult.put(new Vertex(1000000000020L), 15);
		Map<Vertex, Integer> realResult = DagUtil.longestPathInDagFromSpecifiedVertex(realTopSortedDag, realDag,
				new Vertex(1000000000001L));

		TestLongestPath(expectedResult, realResult, new Vertex(1000000000001L));

		Map<Vertex, Integer> expectedResult2 = new HashMap<>();
		expectedResult2.put(new Vertex(1000000000020L), 10);
		Map<Vertex, Integer> realResult2 = DagUtil.longestPathInDagFromSpecifiedVertex(realTopSortedDag, realDag,
				new Vertex(1000000000010L));

		TestLongestPath(expectedResult2, realResult2, new Vertex(1000000000010L));

		Map<Vertex, Integer> expectedResult3 = new HashMap<>();
		expectedResult3.put(new Vertex(1000000000020L), 14);
		Map<Vertex, Integer> realResult3 = DagUtil.longestPathInDagFromSpecifiedVertex(realTopSortedDag, realDag,
				new Vertex(1000000000003L));

		TestLongestPath(expectedResult3, realResult3, new Vertex(1000000000003L));

		Map<Vertex, Integer> expectedResult4 = new HashMap<>();
		expectedResult4.put(new Vertex(1000000000020L), 14);
		Map<Vertex, Integer> realResult4 = DagUtil.longestPathInDagFromSpecifiedVertex(realTopSortedDag, realDag,
				new Vertex(1000000000002L));

		TestLongestPath(expectedResult4, realResult4, new Vertex(1000000000002L));
		
		Map<Vertex, Integer> expectedResult5 = new HashMap<>();
		expectedResult.put(new Vertex(1000000000020L), 15);
		Map<Vertex, Integer> realResult5 = DagUtil.longestPathInDagFromUsingTopSort(realTopSortedDag, realDag,
				new Vertex(1000000000001L));

		TestLongestPathWithTopSort(expectedResult, realResult, new Vertex(1000000000001L));

		
	}

	public static void TestIndegreesMethod(Map<Vertex, Integer> testData, Map<Vertex, Integer> realData) {
		if (testData.size() == realData.size()) {
			System.out.println("Passed: Expected and Real Indegrees Map Sizes are Equal");
		} else {
			System.out.println("Failed: Expected and Real Indegrees Map Sizes are NOT Equal");
		}
		;

		if (testData.equals(realData)) {
			System.out.println("Passed: Expected and Real Indegrees Map Objects are Equal");
		} else {
			System.out.println("Failed: Expected and Real Indegrees Map Objects are NOT Equal");
		}
		;
	}

	public static void TestGenerateDagMethod(Map<Vertex, List<Edge>> expectedDag, Map<Vertex, List<Edge>> realDag) {
		if (expectedDag.equals(realDag)) {
			System.out.println("Passed: Expected and Real DAGs are Equal");
		} else {
			System.out.println("Failed: Expected and Real DAGs are NOT Equal");
		}
	}

	public static void TestDagTopSort(List<Vertex> expectedTopSortDag, List<Vertex> realTopSortDag) {
		if (expectedTopSortDag.equals(realTopSortDag)) {
			System.out.println("Passed: Expected and Real Topographic Sorted DAGs are Equal");
		} else {
			System.out.println("Failed: Expected and Real Topographic Sorted DAGs are NOT Equal");
		}
	}

	public static void TestLongestPath(Map<Vertex, Integer> expectedResult, Map<Vertex, Integer> realResult, Vertex sourceVertex) {
		if (expectedResult.equals(realResult)) {
			System.out.printf("Passed: Expected and Real Longest Paths from vertex {%s} are Equal%n", sourceVertex.id);
		} else {
			System.out.printf("Failed: Expected and Real Longest Paths from vertex {%s} are NOT Equal%n", sourceVertex.id);
		}
	}

	public static void TestLongestPathWithTopSort(Map<Vertex, Integer> expectedResult, Map<Vertex, Integer> realResult, Vertex sourceVertex) {
		if (expectedResult.equals(realResult)) {
			System.out.printf("Passed: Expected and Real Longest Paths with Topological Sort from vertex {%s} are Equal%n", sourceVertex.id);
		} else {
			System.out.printf("Failed: Expected and Real Longest Paths with Topological Sort from vertex {%s} are NOT Equal%n", sourceVertex.id);
		}
	}
}
