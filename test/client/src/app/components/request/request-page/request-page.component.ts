import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { RequestService } from 'src/app/services/request/request.service';

@Component({
  selector: 'app-request-page',
  templateUrl: './request-page.component.html',
  styleUrls: ['./request-page.component.scss']
})
export class RequestPageComponent implements OnInit {

  request_method= "GET";
  methods: String[]=["GET", "PUT", "POST", "DELETE"];
  requestForm!: FormGroup;
  selectFormControl = new FormControl('');
  body_json: any;
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private requestService: RequestService,

  ) { 
    this.createForm();
  }

  ngOnInit(): void {
    
  }

  createForm(): void {
    this.requestForm = this.fb.group({
        request: [''],
        body: [''],
        result:[''],
   });
  }

  send_request(): void {

    console.log(this.request_method)
    console.log(this.requestForm.get("request")?.value)

    if (this.request_method == "GET"){
      this.get_method();
    }else if (this.request_method == "POST"){
      this.post_method();
    } else if (this.request_method == "PUT"){
      this.put_method();
    } else if (this.request_method == "DELETE"){
      this.delete_method();
    }

  }

  valueChanged(req: any): void {
    this.request_method= req;
 
  }

  get_method(): void{
    console.log("GET method choosed")
    console.log(this.requestForm.get("request")?.value)
    this.requestService.get_method(this.requestForm.get("request")?.value).subscribe(
      res => {
        console.log(res);
        this.requestForm.get("result")?.setValue(JSON.stringify(res));
      }, error =>{
        this.requestForm.get("result")?.setValue("ERROR "+JSON.stringify(error));
      }
    )
  }


  post_method(): void{
    console.log("POST method choosed")
    console.log(this.requestForm.get("request")?.value)
    this.body_json = JSON.parse(this.requestForm.get("body")?.value);
    console.log(this.body_json);
    this.requestService.post_method(this.requestForm.get("request")?.value, this.body_json).subscribe(
      res => {
        console.log(res)
        this.requestForm.get("result")?.setValue(JSON.stringify(res));
      }, error =>{
        this.requestForm.get("result")?.setValue("ERROR "+JSON.stringify(error));
      }
    )
  }
 
  put_method(): void{
    console.log("PUT method choosed")
    console.log(this.requestForm.get("request")?.value)
    this.body_json = JSON.parse(this.requestForm.get("body")?.value);
    this.requestService.put_method(this.requestForm.get("request")?.value, this.body_json).subscribe(
      res => {
        console.log(res);
        this.requestForm.get("result")?.setValue(JSON.stringify(res));
      }, error =>{
        this.requestForm.get("result")?.setValue("ERROR "+JSON.stringify(error));
      }
    )
  }

  delete_method(): void {
    console.log("DELETE method choosed")
    console.log(this.requestForm.get("request")?.value)
    this.requestService.delete_method(this.requestForm.get("request")?.value).subscribe(
      res => {
        console.log(res);
        this.requestForm.get("result")?.setValue(JSON.stringify(res));
      }, error =>{
        this.requestForm.get("result")?.setValue("ERROR "+JSON.stringify(error));
      }
    )

  }

}
