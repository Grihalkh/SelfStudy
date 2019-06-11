class Node:
    def __init__(self, value, next_node=None):
        self.value = value
        self.next_node = next_node

    def set_next(self, new_next_node):
        self.next_node = new_next_node


class ConList:

    def __init__(self, lst=None):
        self.nodes = []
        self.pointer = None
        if lst is not None:
            for i in lst:
                self.insert(i)

    def insert(self, value):
        new_node = Node(value)
        self.nodes.append(new_node)
        n = len(self.nodes)
        if n > 1:
            self.nodes[n-2].set_next(new_node)

    def get(self):
        if len(self.nodes) > 0:
            self.pointer = self.nodes[0]
        else:
            return None
        return self.pointer.value

    def next(self):
        if self.pointer is not None:
            self.pointer = self.pointer.next_node

    def pop(self):
        if self.pointer is self.nodes[-1]:
            self.pointer = None

        tempval = self.nodes[-1].value
        del self.nodes[-1]
        return tempval

    def __str__(self):
        if len(self.nodes) == 0:
            return 'Empty connected list'

        ptr = self.nodes[0]
        string = '[' + str(ptr.value)
        while ptr.next_node:
            ptr = ptr.next_node
            string += '->' + str(ptr.value)
        string += ']'
        return string


class Stack:

    def __init__(self, lst=None):
        self.nodes = []
        self.count = 0
        if lst is not None:
            for i in lst:
                self.push(i)

    def push(self, value):
        new_node = Node(value)
        self.nodes.append(new_node)
        n = len(self.nodes)
        if n > 1:
            self.nodes[n-2].set_next(new_node)
        self.count += 1

    def peek(self):
        if len(self.nodes) == 0:
            return None
        return self.nodes[-1].value

    def pop(self):
        tempval = self.nodes[-1].value
        del self.nodes[-1]
        self.nodes[-1].set_next(None)
        self.count -= 1
        return tempval

    def __str__(self):
        if len(self.nodes) == 0:
            return 'Empty stack'

        ptr = self.nodes[0]
        string = '[' + str(ptr.value)
        while ptr.next_node:
            ptr = ptr.next_node
            string += '->' + str(ptr.value)
        string += ']'
        return string


class Queue:
    def __init__(self, lst=None):
        self.nodes = []
        self.count = 0
        if lst is not None:
            for i in lst:
                self.enqueue(i)

    def enqueue(self, value):
        new_node = Node(value)
        self.nodes.append(new_node)
        n = len(self.nodes)
        if n > 1:
            self.nodes[n - 2].set_next(new_node)
        self.count += 1

    def peek(self):
        if len(self.nodes) == 0:
            return None
        return self.nodes[0].value

    def dequeue(self):
        tempval = self.nodes[0].value
        del self.nodes[0]
        self.count -= 1
        return tempval

    def __str__(self):
        if len(self.nodes) == 0:
            return 'Empty queue'

        ptr = self.nodes[0]
        string = '[' + str(ptr.value)
        while ptr.next_node:
            ptr = ptr.next_node
            string += '->' + str(ptr.value)
        string += ']'
        return string
