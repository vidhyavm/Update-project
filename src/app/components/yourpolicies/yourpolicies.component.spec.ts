import { ComponentFixture, TestBed } from '@angular/core/testing';

import { YourpoliciesComponent } from './yourpolicies.component';

describe('YourpoliciesComponent', () => {
  let component: YourpoliciesComponent;
  let fixture: ComponentFixture<YourpoliciesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [YourpoliciesComponent]
    });
    fixture = TestBed.createComponent(YourpoliciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
