qs
====================

Scheduler that takes into account causal relations between operations within the transactions and the transactions themselves. The objective is to schedule the operations for geo-replication without breaking causal relations and without separating the operations within the transactions.


Earliest Deadline First type scheduling based on K value vectors (time, sequence, value).

Work developed as part of my master thesis.

To be merged with Omid.
