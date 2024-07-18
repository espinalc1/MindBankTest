package mindBankTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vertex {
	long id;

	public Vertex(Long id) {
		this.id = id;
	}

	public static Set<Vertex> generateVertices(List<Long> verticesIds) {
		Set<Vertex> vertices = new HashSet<>();
		for (Long id : verticesIds) {
			vertices.add(new Vertex(id));
		}
		return vertices;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
