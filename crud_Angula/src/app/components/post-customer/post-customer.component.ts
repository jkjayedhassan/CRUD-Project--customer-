import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-post-customer',
  templateUrl: './post-customer.component.html',
  styleUrls: ['./post-customer.component.scss']
})
export class PostCustomerComponent implements OnInit {

  postCustomerForm: FormGroup;

  constructor(private fb: FormBuilder, private customerService: CustomerService, private router: Router) {
    this.postCustomerForm = this.fb.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required]]
    });
   }

  ngOnInit(): void {
  }

  postCustomer(){
    console.log(this.postCustomerForm.value);
    if(this.postCustomerForm.valid){
      this.customerService.postCustomer(this.postCustomerForm.value).subscribe((res)=>{
        console.log(res); 
        this.router.navigate(['']);
      });
    }
   
    
  }
}
