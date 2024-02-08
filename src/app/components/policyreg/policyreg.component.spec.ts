import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PolicyregComponent } from './policyreg.component';

describe('PolicyregComponent', () => {
  let component: PolicyregComponent;
  let fixture: ComponentFixture<PolicyregComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PolicyregComponent]
    });
    fixture = TestBed.createComponent(PolicyregComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
