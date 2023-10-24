# customer_info

A RESTful API to manage customers and their contact information.

## API Endpoints:

1. Add a New Customer:
Endpoint: /api/customers
- Method: POST
- Body: 
  json
  {
    "name": "John Doe"
  }

2. Add a New Customer Contact:
Endpoint: /api/customers/{customerId}/contacts
Method: POST
Body:
json
Copy code
{
  "type": "EMAIL",
  "value": "john.doe@example.com"
}

3. Get All Customers:
Endpoint: /api/customers
Method: GET

4. Get Customer by ID:
Endpoint: /api/customers/{customerId}
Method: GET

5. Get Contacts of a Customer:
Endpoint: /api/customers/{customerId}/contacts
Method: GET

6. Get Contacts of a Specific Type for a Customer:
Endpoint: /api/customers/{customerId}/contacts/{type}
Method: GET
