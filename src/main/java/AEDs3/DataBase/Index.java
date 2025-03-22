package AEDs3.DataBase;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

interface Index {
	public long search(int id) throws IOException;
	public void insert(int id, long pos) throws IOException;
	// public void delete(int id) throws IOException;
	// public void update(int id, long newPos) throws IOException;
	// public void destruct() throws IOException;
}

class IndexRegister implements Externalizable, Comparable<IndexRegister> {
	int id;
	long pos;

	public IndexRegister(int id, long pos) {
		this.id = id;
		this.pos = pos;
	}

	public int compareTo(IndexRegister other) {
		return Integer.compare(id, other.getId());
	}

	public void readExternal(ObjectInput in) throws IOException {
		id = in.readInt();
		pos = in.readLong();
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeLong(pos);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPos() {
		return pos;
	}

	public void setPos(long pos) {
		this.pos = pos;
	}
}
