#include <iostream>
using namespace std;

// Node structure for the BST
struct Node {
    int data;
    Node* left;
    Node* right;
};

// Function to create a new BST node
Node* createNode(int value) {
    Node* newNode = new Node();
    newNode->data = value;
    newNode->left = newNode->right = nullptr;
    return newNode;
}

// Function to insert a value into the BST
Node* insert(Node* root, int value) {
    if (root == nullptr) {
        return createNode(value);
    }
    if (value < root->data) {
        root->left = insert(root->left, value);
    } else {
        root->right = insert(root->right, value);
    }
    return root;
}

// In-order traversal to get sorted elements
void inorderTraversal(Node* root) {
    if (root != nullptr) {
        inorderTraversal(root->left);
        cout << root->data << " ";
        inorderTraversal(root->right);
    }
}

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    int arr[n];
    cout << "Enter " << n << " elements:\n";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    Node* root = nullptr;
    // Insert elements into the BST
    for (int i = 0; i < n; i++) {
        root = insert(root, arr[i]);
    }

    cout << "Sorted elements using Tree Sort:\n";
    inorderTraversal(root);

    return 0;
}

