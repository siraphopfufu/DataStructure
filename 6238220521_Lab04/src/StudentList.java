
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) {
		
		Student student = (Student) i1.currentNode.data;
		i1.currentNode.data = i2.currentNode.data;
		i2.currentNode.data = student;
		
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) {
		
		if (lst.isEmpty())
			return;
		
		lst.header.previousNode.nextNode = i1.currentNode.nextNode;
		i1.currentNode.nextNode.previousNode = lst.header.previousNode;
		
		i1.currentNode.nextNode = lst.header.nextNode;
		lst.header.nextNode.previousNode = i1.currentNode;
		
		size += lst.size;
		
	}

	// implement this method
	public void gender(String g) throws Exception {
		
		StudentList newStudentList = new StudentList();
		
		DListIterator i1 = new DListIterator(newStudentList.header);
		DListIterator i2 = new DListIterator(header.nextNode);
		
		while(i2.hasNext()) {
			
			if (i2.currentNode == header)
				break;
			Student student = (Student) i2.currentNode.data;
			i2.next();
			if (!student.getSex().equals(g)) {
				newStudentList.insert(student, i1);
				i1.next();
				remove(student);
			}
			
		}
		
		i2.previous();
		insertList(i2, newStudentList);
		
	}

}
