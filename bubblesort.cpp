#include <iostream>
using namespace std;

int main() {
    int n;

    // Input the number of elements
    cout << "Enter the number of elements: ";
    cin >> n;

    int arr[n];

    // Input array elements
    cout << "Enter " << n << " elements:\n";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    // Bubble Sort algorithm
    for (int i = 0; i < n - 1; i++) {
        // Last i elements are already in place
        for (int j = 0; j < n - i - 1; j++) {
            // Swap if elements are in the wrong order
            if (arr[j] > arr[j + 1]) {
                // Swap using a temporary variable
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

    // Print the sorted array
    cout << "Sorted array in ascending order:\n";
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }

    return 0;
}

