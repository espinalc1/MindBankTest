package mindBankTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Edge {
	Vertex from;
	Vertex to;

	public Edge(Vertex from, Vertex to) {
		this.from = from;
		this.to = to;
	}

	public static Set<Edge> generateEdgeSet(List<List<Long>> edgeDirectionsList) {
		Set<Edge> edges = new HashSet<>();
		for (List<Long> edgeDirection : edgeDirectionsList) {
			Vertex fromVertex = new Vertex(edgeDirection.get(0));
			Vertex toVertex = new Vertex(edgeDirection.get(1));
			Edge edge = new Edge(fromVertex, toVertex);
			edges.add(edge);
		}
		return edges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

}
