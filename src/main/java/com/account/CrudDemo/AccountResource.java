package com.account.CrudDemo;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AccountResource {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@GetMapping("/accounts")
	public List<Account> retrieveAllAccounts() {
		return accountRepository.findAll();
	}
	
	@GetMapping("/transactions")
	public List<Transactions> retrieveAllTransactionss() {
		return transactionRepository.findAll();
	}
	@GetMapping("/students/{id}")
	public Account retrieveAccount(@PathVariable long id) {
		Optional<Account> account = accountRepository.findById(id);

		if (!account.isPresent())
			System.out.println("StudentNotFoundException");
			//throw new  Exception("Student not found");
			//throw new StudentNotFoundException("id-" + id);

		return account.get();
		
	}
	
	@PostMapping("/transactions")
	public ResponseEntity<Object> createTransaction(@RequestBody Transactions transactions) {
		Transactions savedTransaction = transactionRepository.save(transactions);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTransaction.getTransactionId()).toUri();
		return ResponseEntity.created(location).build();

	}
	
	@PostMapping("/account")
	public ResponseEntity<Object> createAccount(@RequestBody Account account) {
		Account savedAccount = accountRepository.save(account);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedAccount.getId()).toUri();
		return ResponseEntity.created(location).build();

	}
	
}