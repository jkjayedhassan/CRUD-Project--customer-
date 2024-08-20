import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.scss']
})
export class UpdateCustomerComponent {
  updateCustomerForm: FormGroup;
  id: number = this.activedRoute.snapshot.params["id"];


  constructor(private activedRoute: ActivatedRoute, private customerService: CustomerService, private fb: FormBuilder, private router: Router) {
    this.updateCustomerForm = this.fb.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required]]
    });
  }
  ngOnInit() {
    this.getCustomerById();
  }

  getCustomerById() {
    this.customerService.getCustomerById(this.id).subscribe((res) => {
      console.log(res)
      this.updateCustomerForm.patchValue(res);

    })
  }

  updateCustomer() {
    this.customerService.updateCustomer(this.id, this.updateCustomerForm.value).subscribe((res) => {
      console.log(res);
      if (res.id != null) {
        this.router.navigate(['']);
      }
    });

  }



}
