#pragma once
#include <iostream>
namespace task2
{
	struct Node
	{
		Node() {}
		Node(int n)
		{
			this->n = n;
		}

		Node* l = nullptr, * r = nullptr;
		int n;
	};

	Node* createGoodTree()
	{
		Node* root = new Node(4);
		root->r = new Node(5);
		root->l = new Node(2);
		root->l->l = new Node(1);
		root->l->r = new Node(3);
		return root;
	}

	Node* createBadTree()
	{
		Node* root = new Node(3);
		root->r = new Node(5);
		root->l = new Node(2);
		root->l->l = new Node(1);
		root->l->r = new Node(4);
		return root;
	}

	void deleteTree(Node* node)
	{
		if (node->l)
			deleteTree(node->l);
		if (node->r)
			deleteTree(node->r);
		delete node;
	}

	bool binary_search(const Node* root, int n)
	{
		if (root->n == n)
			return true;

		bool result = false;
		if (n < root->n && root->l)
			result = binary_search(root->l, n);
		if (n > root->n && root->r)
			result = binary_search(root->r, n);

		return result;
	}

	bool check_all_numbers(const Node* root, const Node* curr)
	{
		bool result = binary_search(root, curr->n);
		if (curr->l && result)
			result = check_all_numbers(root, curr->l);
		if (curr->r && result)
			result = check_all_numbers(root, curr->r);

		return result;
	}

	bool is_binary_search_tree(const Node* root)
	{
		bool result = check_all_numbers(root, root->l);
		if (result)
			result = check_all_numbers(root, root->r);
		return result;
	}

	int main()
	{
		Node* root = createBadTree();

		printf("Result = %d", is_binary_search_tree(root));

		deleteTree(root);
		return 0;
	}

}