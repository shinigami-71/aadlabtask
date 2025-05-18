#include <iostream>
using namespace std;

// Function to perform Insertion Sort
void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];      // Element to be inserted
        int j = i - 1;

        // Shift elements of arr[0..i-1] that are greater than key
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        // Place key at the correct position
        arr[j + 1] = key;
    }
}

// Function to print the array
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;
}

// Main function
int main() {
    int n;

    cout << "Enter number of elements: ";
    cin >> n;

    int arr[n];
    cout << "Enter " << n << " elements:\n";
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    cout << "Original array: ";
    printArray(arr, n);

    insertionSort(arr, n);

    cout << "Sorted array: ";
    printArray(arr, n);

    return 0;
}

