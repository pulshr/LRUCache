# LRUCache

Application and Working: 
 - Cache algorithms (cache replacement algorithms or cache replacement policies) are optimized instructions that a computer program or a hardware-maintained
   structure can follow in order to manage a cache of information stored on the computer
 - When the cache is full, the algorithm must choose which items to discard to make room for the new ones
 - In This Project we Implements Cache Simulator using Least Recently Used LRU.

Implementation:
 - Least Recently Used (LRU) algorithm requires keeping track of what was used when, which is expensive if one wants to make sure the 
  algorithm always discards the least recently used item
 - I used two data structures to implement this LRU Cache:
    - Queue
      - Implemented using a doubly linked list, the maximum size of the queue will be equal to the capacity provided during the initialization
      - The most recently used pages will be near front end and least recently pages will be near rear end
    - Hash
      - Implemented using a Hash Table to map the keys with the corresponding nodes present in the cache
      - This will help to access any node of cache in O(1) time even in the worst case
 
Complexity Analysis:
  - Time Complexity:
      - Put operation:
            - As adding a node in the list and removing a node from the list take constant time, therefore overall time complexity is O(1)
      - Get Operation:
            - Accessing a node from the map and moving a node of the list to its head can also be executed in a constant amount. So this is also O(1)
  - Space Complexity:
            - I am using a DLL and a HashMap whose size can reach up to N, where N is the size of the cache. Therefore, the overall space complexity is O(n)
