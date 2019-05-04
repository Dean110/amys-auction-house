# Amy's Auction House
## Design Document
> ###### ver. 0.1

### Overview
Amy's Auction House is a auction application that supports multiple bidders, auction items, and sellers.  Currently the app is planned to mimic an estate or community auction.  That is to say, one event with multiple items, multiple bidders, and one window for bidding.  The app will be broken into a few different modules: listing management, user management, bid management, and financial management.

### Listing Management Overview
The listing management will handle the intake of items up for bid before the auction starts.  Setting reserves for items, opening bids, item descriptions, item picture url's, setting start and end times, and other listing duties will be handled in this module.

### User Management Overview
Setting up bidders and managing their information will be handled in this module.  Different users will have roles that manage permissions and the actions they can take in the application.  

### Bid Management Overview
The bid management will handle accepting incoming bids for items and ensuring that bids are handled according to business rules.  

### Financial Management Overview
Runs a batch process to invoice bidders at the end of the auction and keep track of auction totals.