package mindBankTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DagUtil {

	public static Map<Vertex, Integer> longestPathInDagFromUsingTopSort(List<Vertex> topSortDag,
			Map<Vertex, List<Edge>> dag, Vertex selectedVertex) {
		// find the starting vertex in the topSortDag

		Map<Vertex, Integer> minValuesMap = new HashMap<>();

		for (Vertex vertex : topSortDag) {
			minValuesMap.put(vertex, Integer.MAX_VALUE);
		}

		minValuesMap.put(selectedVertex, 0);

		// memoize the longest path destination and longest path distance
		Vertex currentLongestPathDestinationVertex = selectedVertex;
		Integer longestPathDistance = 0;

		// traverse the topsortdag
		for (Vertex currentVertex : topSortDag) {
			Integer currentVertexDistance = minValuesMap.get(currentVertex);
			List<Edge> edgesFromCurrentVertex = dag.get(currentVertex);
			if (edgesFromCurrentVertex != null) {
				for (Edge edge : edgesFromCurrentVertex) {
					Vertex destinationVertex = edge.to;
					Integer destinationVertexDistance = minValuesMap.get(destinationVertex);
					destinationVertexDistance = Math.min(currentVertexDistance - 1, destinationVertexDistance);
					minValuesMap.put(destinationVertex, destinationVertexDistance);

					// update memoized value
					if (destinationVertexDistance < longestPathDistance) {
						longestPathDistance = destinationVertexDistance;
						currentLongestPathDestinationVertex = destinationVertex;
					}
				}
			}
		}

		// populate the min-values map with data using a non-weighted "-graph" DAG

		// return the longest path value by multiplying the -g shortest path by -1.
		longestPathDistance = longestPathDistance * (-1);
		Map<Vertex, Integer> solution = new HashMap<>();
		solution.put(currentLongestPathDestinationVertex, longestPathDistance);
		return solution;
	}

	public static Map<Vertex, Integer> longestPathInDagFromSpecifiedVertex(List<Vertex> topSortDag,
			Map<Vertex, List<Edge>> dag, Vertex selectedVertex) {
		// find the starting vertex in the topSortDag

		Map<Vertex, Integer> minValuesMap = new HashMap<>();

		for (Vertex vertex : topSortDag) {
			minValuesMap.put(vertex, Integer.MAX_VALUE);
		}

		minValuesMap.put(selectedVertex, 0);
		// traverse the dag through the chosen vertex

		Queue<Vertex> vertexQueue = new LinkedList<>();
		vertexQueue.offer(selectedVertex);

		// memoize the longest path destination and longest path distance
		Vertex currentLongestPathDestinationVertex = selectedVertex;
		Integer longestPathDistance = 0;

		// populate the min-values map with data using a non-weighted "-graph" DAG
		while (vertexQueue.size() > 0) {
			Vertex currentVertex = vertexQueue.poll();
			Integer currentVertexDistance = minValuesMap.get(currentVertex);
			List<Edge> edgesFromCurrentVertex = dag.get(currentVertex);
			if (edgesFromCurrentVertex != null) {
				for (Edge edge : edgesFromCurrentVertex) {
					Vertex destinationVertex = edge.to;
					vertexQueue.offer(destinationVertex);
					Integer destinationVertexDistance = minValuesMap.get(destinationVertex);
					destinationVertexDistance = Math.min(currentVertexDistance - 1, destinationVertexDistance);
					minValuesMap.put(destinationVertex, destinationVertexDistance);

					// update memoized value
					if (destinationVertexDistance < longestPathDistance) {
						longestPathDistance = destinationVertexDistance;
						currentLongestPathDestinationVertex = destinationVertex;
					}
				}

			}
		}

		// return the longest path value by multiplying the -g shortest path by -1.
		longestPathDistance = longestPathDistance * (-1);
		Map<Vertex, Integer> solution = new HashMap<>();
		solution.put(currentLongestPathDestinationVertex, longestPathDistance);
		return solution;
	}

	public static List<Vertex> getTopSortDag(Set<Vertex> vertices, Map<Vertex, Integer> indegreesMap,
			Map<Vertex, List<Edge>> dag) {

		// add to queue if vertex's in-degree amount is zero
		Deque<Vertex> queue = new LinkedList<>();
		for (Vertex vertex : vertices) {
			if (indegreesMap.get(vertex) == 0) {
				queue.push(vertex);
			}
		}

		List<Vertex> topSortedDagList = new ArrayList<>();
		while (queue.size() > 0) {
			// remove (poll) the top-most vertex in the queue
			Vertex vertex = queue.poll();
			// get the vertex from the dag map and scroll through the list of edges to find
			// destinations
			List<Edge> edgeList = dag.get(vertex);
			if (edgeList != null) {
				for (Edge edge : edgeList) {
					// in each edge, reduce the destination vertex indegreesMap value by 1
					int count = indegreesMap.get(edge.to) - 1;
					indegreesMap.put(edge.to, count);
					// if the destination vertex reaches 0 place in the queue
					if (count == 0) {
						queue.add(edge.to);
					}
				}
			}
			// once scrolled through all of the edges in the list add it to the top sorted
			// dag list
			topSortedDagList.add(vertex);
		}

		return topSortedDagList;
	}

	public static List<Edge> generateEdgeList(List<List<Long>> edgeDirectionsList) {
		Set<Edge> edgeSet = Edge.generateEdgeSet(edgeDirectionsList);
		List<Edge> edgeList = new ArrayList<>(edgeSet);
		return edgeList;
	}

	public static Map<Vertex, List<Edge>> generateDag(List<Edge> edgeList) {
		Map<Vertex, List<Edge>> dag = new HashMap<>();
		for (Edge edge : edgeList) {
			if (dag.containsKey(edge.from)) {
				List<Edge> edgesFromVertexKey = dag.get(edge.from);
				edgesFromVertexKey.add(edge);
				dag.put(edge.from, edgesFromVertexKey);
			} else {
				List<Edge> edgeListValue = new ArrayList<>();
				edgeListValue.add(edge);
				dag.put(edge.from, edgeListValue);
			}

			dag.putIfAbsent(edge.from, Arrays.asList(edge));
		}
		return dag;

	}

	public static Map<Vertex, Integer> calculateInDegrees(Set<Vertex> vertices, List<Edge> edges) {
		Map<Vertex, Integer> indegreesMap = new HashMap<>();

		for (Vertex vertex : vertices) {
			indegreesMap.putIfAbsent(vertex, 0);
		}

		for (Edge edge : edges) {
			if (indegreesMap.containsKey(edge.to)) {
				int count = indegreesMap.get(edge.to) + 1;
				indegreesMap.put(edge.to, count);
			}
		}

		return indegreesMap;
	}

}
